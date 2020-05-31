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
        stages {
            stage('Building image') {
                steps{
                    script {
                        docker.build registry + ":$BUILD_NUMBER"
                    }
                }
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