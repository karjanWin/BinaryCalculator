pipeline {
    agent any
    tools {
        maven 'Maven-BT' // Use the configured Maven version
    }
    stages {
        stage('Clone Repository') {
            steps {
                git credentialsId: 'github-PAT', branch: 'main', url: 'https://github.com/karjanWin/BinaryCalculator.git'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarBT') { // Name configured in Jenkins
                    bat 'mvn sonar:sonar'
                }
            }
        }
    }
    post {
        always {
            junit '**\\target\\surefire-reports\\*.xml'
            archiveArtifacts artifacts: '**\\target\\*.jar', allowEmptyArchive: true
        }
    }
}
