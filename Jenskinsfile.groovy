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
            sh  "docker rmi ecommercer || true"

            echo  "Criando imagem Docker do project..."
            sh  "docker images ecommercer-latest "
            sh  "docker build -t ecommerce:latest  ."
            sh  "docker images | grep ecommercer"
        }
    }
    stage ("Criando container e teste de execução..") {
        steps{
            sh  "docker rm -f ecommerce || true"
            sh  "docker run --rm ecommerce"
        }
    }
    stage("deploy") {
        steps {
            echo  "deploying the application..."
        }
    }
  }
}