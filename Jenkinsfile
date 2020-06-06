pipeline {
    environment {
        dockerHubAccount = "skoogle"
        dockerImage = "skoogle-desktop:0.0.1-SNAPSHOT"
        dockerImageTag = ":0.0.1-SNAPSHOT"

        registry = "skoogle/skoogle-desktop"
        registryCredential = 'dockerhub'
        dockerHubImage = 'skoogle-desktop:0.0.1-SNAPSHOT'
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
                sh './gradlew test'
            }
        }
        stage('Building image') {
            steps {
                sh 'docker build -t ' + dockerImage + ' .'
                sh 'docker tag ' + dockerImage + ' ' + dockerHubAccount + "/" + dockerImage
                sh 'docker image list'
            }
        }

    }
}