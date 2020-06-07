pipeline {
    environment {
        registryCredential = 'dockerhub'
        dockerImage = "skoogle/skoogle-desktop:0.0.1-SNAPSHOT"
    }
    agent any
    stages {
        stage('Gradle Build') {
            steps {
                sh './gradlew clean build'
            }
        }
        stage('Test'){
            steps {
                sh './gradlew clean test'
            }
        }
        stage('Building image') {
            steps {
                sh 'docker build -t ' + dockerImage + ' .'
                sh 'docker tag ' + dockerImage + ' ' + dockerImage
                sh 'docker image list'
            }
        }

    }
}