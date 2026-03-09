pipeline {
    agent {
        label  'ecommerce'
    }
    stages {
        stage ("build") {
            steps {
                echo "building the application..."
                sh  "/home/pablo/.nvm/versions/node/v20.17.0/bin/node -v"
                 sh  "ls -la"
        }
    }
    stage ("test") {
        steps {
            echo  "testing the application"
        }
    }
    stage ("Build Image...") {
        steps {
            echo  "Criando imagem Docker do projet..."
            sh  "docker build -t ecommerce ."
            sh  "docker images"

        }
    }
    stage ("Criando container e teste de execução..") {
        steps{
            sh  "docker rm -f ecommerce || true"
        }
    }
    stage("deploy") {
        steps {
            echo  "deploying the application..."
        }
    }
  }
}