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
            }
        }
        stage('Building image') {
            steps {
                sh './gradlew docker'
            }
        }
        stage('Push Image') {
            steps {
                sh 'docker push skoogle/skoogle-desktop:0.0.1-SNAPSHOT'
            }
        }
    }
}