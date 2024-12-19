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
                // Ensure Maven uses the correct paths for SonarQube analysis 
                bat '''
                 mvn sonar:sonar ^
                -Dsonar.projectKey=BDC ^
                -Dsonar.host.url=http://localhost:9000 ^
                -Dsonar.login=sqp_c1c8dc770bacf6e56b86eb9240addf3b7ed81603 ^
                -Dsonar.scm.provider=git
                '''
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
