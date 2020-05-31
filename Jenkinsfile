pipeline {
    environment {
        registry = "skoogle/skoogle-desktop"
        registryCredential = 'dockerhub'
        dockerImage = 'skoogle-desktop-0.0.1-SNAPSHOT.jar'
    }
    agent any
    options {
        skipStagesAfterUnstable()
    }
    stages {
        stage('Gradle Build') {
            steps {
                sh './gradlew clean build'
            }
        }
        stage('Test'){
            steps {
                sh './gradlew test'
                junit '/build/reports/tests/test/*.xml'
            }
        }
        stage('Docker Image') {
            steps {
                sh './gradlew docker'
            }
        }
        stage('Push Image') {
            steps{
                script {
                    docker.withRegistry( '', registryCredential ) {
                        dockerImage.push()
                    }
                }
            }
        }
    }
}