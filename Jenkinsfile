// param for RELEASE_VERSION - if empty, generate snapshot build, otherwise, release build
// this pipeline doesn't do release management (yet), so test->release is still a manual process

pipeline {
	parameters {
		string name: 'RELEASE_VERSION', defaultValue: '', description: '(e.g., 1.0.0, leave blank for current snapshot)', trim: true
	}

	agent {
		label 'atlassian'
	}

	stages {
		stage('Build plugin') {
			steps {
				withCache(name: 'codedx-bamboo-cache', baseFolder: env.HOME, contents: '.m2') {
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
					archiveArtifacts artifacts: 'target/codedx-bamboo-plugin*.jar', fingerprint: true, onlyIfSuccessful: true

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
}
