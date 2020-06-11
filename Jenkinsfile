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
                sh 'docker build -t ' + dockerImage + ' .'
                sh 'docker tag ' + dockerImage + ' ' + dockerImage
                sh 'docker image list'
            }
        }
        stage('Push image') {
            steps {
                withCredentials( [usernamePassword(credentialsId: registryCredential, usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')] ) {
                    sh 'docker login -u ${USERNAME} -p ${PASSWORD}'
                    sh 'docker push ' + dockerImage
                }
            }
        }
        stage('Remove unused docker image') {
            steps {
                sh 'docker rmi ' + dockerImage
            }
        }
    }
}
