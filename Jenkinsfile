pipeline {
    environment {
        registry = "skoogle/skoogle-desktop"
        registryCredential = 'dockerhub'
        dockerImage = ''
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
                    docker.withRegistry( 'https://registry.hub.docker.com', registryCredential ) {
                        sh 'docker push skoogle-desktop:0.0.' + ':$BUILD_NUMBER'
                    }
                }
            }
        }
        stage('Remove unused docker image') {
            steps {
                sh 'docker rmi $registry:$BUILD_NUMBER'
            }
        }
    }
}