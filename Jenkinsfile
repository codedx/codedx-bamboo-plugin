// param for RELEASE_VERSION - if empty, generate snapshot build, otherwise, release build
// this pipeline doesn't do release management (yet), so test->release is still a manual process

pipeline {
	agent {
		dockerfile {
			dir 'repo/sdk-image'
		}
	}

	options {
		buildDiscarder logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '', numToKeepStr: '20')
	}

	parameters {
		string name: 'RELEASE_VERSION', defaultValue: '', description: '(e.g., 1.0.0, leave blank for current snapshot)', trim: true
	}

	stages {
		stage('Build plugin') {
			environment {
				// we'll be one directory deep. this is a little brittle, but there's no clean way
				// to use $WORKSPACE here if it contains spaces it seems
				ATLAS_OPTS = "-Dmaven.repo.local=../maven-cache"
			}

			steps {
				dir("repo/") {
					script {
						if (params.RELEASE_VERSION != "") {
							sh "atlas-mvn versions:set -DnewVersion=${params.RELEASE_VERSION}"
						}
					}

					sh 'atlas-unit-test'
					sh 'atlas-package'
				}
			}

			post {
				success {
					archiveArtifacts artifacts: 'repo/target/codedx-bamboo-plugin*.jar', fingerprint: true, onlyIfSuccessful: true

					script {
						if (params.RELEASE_VERSION != "") {
							currentBuild.displayName = params.RELEASE_VERSION
							currentBuild.description = "Release build ${params.RELEASE_VERSION}"
							currentBuild.setKeepLog(true)
						}
					}
				}
			}
		}
	}

	post {
		always {
			cleanWs deleteDirs: true, patterns: [[pattern: 'repo/target/', type: 'INCLUDE']]
		}
		failure {
			slackSend botUser: true, channel: '#devchat', color: 'danger', message: "Bamboo Plugin build FAILED (<${env.BUILD_URL}|Open>)"
		}
	}
}