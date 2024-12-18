pipeline {
    agent any
    tools {
        maven 'Maven-BT' // Use the configured Maven version
    }
    stages {
        stage('Clone Repository') {
            steps {
                git credentialsId: 'GLPAT', branch: 'main', url: 'https://github.com/karjanWin/BinaryCalculator.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') { // Name configured in Jenkins
                    sh 'mvn sonar:sonar'
                }
            }
        }
    }
    post {
        always {
            junit '**/target/surefire-reports/*.xml'
            archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
        }
    }
}
