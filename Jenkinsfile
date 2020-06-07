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
                sh './gradlew test'
            }
        }
        stage('Building image') {
            steps {
                sh 'sudo docker build -t ' + dockerImage + ' .'
                sh 'sudo docker tag ' + dockerImage + ' ' + dockerImage
                sh 'sudo docker image list'
            }
        }
        stage('Pushing image') {
            steps {
                sh 'sudo docker push ' + dockerImage
            }
        }
        stage('Remove unused docker image') {
            steps {
                sh 'sudo docker rmi ' + dockerImage
            }
        }
    }
}
