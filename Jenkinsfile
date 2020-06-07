pipeline {
    environment {
        registryCredential = 'dockerhub'
        dockerImage = "skoogle/skoogle-desktop:0.0.1-SNAPSHOT"
    }
    agent any
    stages {
        stage('Remove Images') {
            steps {
                sh 'docker rm -vf $(docker ps -a -q)'
                sh 'docker rmi -f $(docker images -a -q)'
            }
        }
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
                sh 'docker tag ' + dockerImage + ' ' + dockerImage
                sh 'docker image list'
            }
        }
        stage('Pushing image') {
            steps {
                sh 'docker push ' + dockerImage
            }
        }

    }
}