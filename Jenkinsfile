pipeline {
    environment {
        registry = "skoogle/skoogle-desktop"
        registryCredential = 'dockerhub'
        dockerImage = 'skoogle-desktop:0.0.1-SNAPSHOT'
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
                sh './gradlew docker'
            }
        }
        stage('Push image') {
            steps {
                script {
                    docker.withRegistry( 'docker.io', registryCredential ) {
                        sh 'docker push skoogle/skoogle-desktop:' + dockerImage
                    }
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