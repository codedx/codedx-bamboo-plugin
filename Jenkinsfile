// check out repo to $WORKSPACE/repo
// we'll store the maven cache in $WORKSPACE/maven-cache

pipeline {
	agent {
		dockerfile {
			dir 'repo/sdk-image'
		}
	}

	parameters {
		string name: 'RELEASE_VERSION', defaultValue: '', description: '(leave blank for current snapshot)', trim: true
	}

	stages {
		stage('Build plugin') {
			environment {
				// we'll be one directory deep. this is a little brittle, but there's no clean way
				// to use $WORKSPACE here if it contains spaces it seems
				ATLAS_OPTS = "-Dmaven.repo.local='../maven-cache'"
			}

			steps {
				dir("repo/") {
					script {
						def isRelease = params.RELEASE_VERSION != ""

						if (isRelease) {
							sh "atlas-mvn versinos:set -DnewVersion=${params.RELEASE_VERSION}"
						}
					}

					//TODO: if release, atlas-mvn versions:set -DnewVersion=version
					sh 'atlas-unit-test'
					sh 'atlas-package'
				}
			}

			post {
				success {
					archiveArtifacts artifacts: 'target/codedx-bamboo-plugin*.jar', fingerprint: true, onlyIfSuccessful: true

					script {
						if (isRelease) {
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