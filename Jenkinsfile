pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    stages {

        stage('Build') {
            steps {
                // Run Maven on a Unix agent.
                sh "mvn clean package -Dmaven.test.skip"
                sh 'docker-compose build'

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }
        }
        stage("Test") {
            steps {
                sh 'docker-compose down && docker-compose up -d mongodb'
                sh 'mvn test'

            }
        }
        stage("Deploy"){
            steps {
                sh 'docker-compose up -d'
            }
        }
    }
}
