// check out repo to $WORKSPACE/repo
// we'll store the maven cache in $WORKSPACE/maven-cache

pipeline {
	agent {
		dockerfile {
			dir 'repo/sdk-image'
		}
	}

	environment {
		ATLAS_OPTS = "-Dmaven.repo.local='$WORKSPACE/maven-cache'"
	}

	stages {
		stage('Build plugin') {
			steps {
				dir("repo/") {
					//TODO: if release, atlas-mvn versions:set -DnewVersion=version
					sh 'atlas-unit-test'
					sh 'atlas-package'

					archiveArtifacts artifacts: 'target/codedx-bamboo-plugin*.jar', fingerprint: true, onlyIfSuccessful: true
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