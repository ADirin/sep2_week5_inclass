pipeline {
    agent any

    environment {
        SONARQUBE_SERVER = 'SonarQubeServer'  // SonarQube server configured in Jenkins
        SONAR_TOKEN = 'sqa_a16db84c9a0a15be9209babf3a2636b0f73021b6'// Replace with your Jenkins credential ID
         DOCKERHUB_CREDENTIALS_ID = 'Docker_Hub' // Replace with your Docker Hub credentials ID
        DOCKER_IMAGE = 'amirdirin/sonarfiletest' // Replace with your Docker Hub image name
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/ADirin/sep2_week5_inclass.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv("${env.SONARQUBE_SERVER}") {
                    bat """
                        sonar-scanner ^
                        -Dsonar.projectKey=devops-demo ^
                        -Dsonar.sources=src ^
                        -Dsonar.projectName=DevOps-Demo ^
                        -Dsonar.host.url=http://localhost:9000 ^
                        -Dsonar.login=${env.SONAR_TOKEN} ^
                        -Dsonar.java.binaries=target/classes
                    """
                }
            }
        }

        stage('Docker Build & Push') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', "${env.DOCKER_HUB_CREDENTIALS}") {
                        def app = docker.build("${DOCKER_IMAGE}:latest")
                        app.push('latest')
                    }
                }
            }
        }
    }
}
