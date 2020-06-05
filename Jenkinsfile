pipeline {
    environment {
        registry = "skoogle/skoogle-desktop"
        registryCredential = 'dockerhub'
        repoTag = 'skoogle-desktop:0.0.1-SNAPSHOT'
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
                sh 'docker tag ' + dockerImage + ' ' + repoTag
            }
        }
        stage('Push image') {
            steps {
                script {
                    docker.withRegistry( 'https://registry.hub.docker.com', registryCredential ) {
                        sh 'docker push ' + dockerImage
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