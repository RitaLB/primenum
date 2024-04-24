# PrimeNum

PrimeNum é uma Aplicação Web que permite que o usuário insira um número inteiro 'k' e calcula o número de inteiros positivos primos n MENORES que 'k'. Ela fornece ao usuário a resposta e o tempo de processamento requerido para tal cálculo. 
Além disso, a aplicação permite que o usuário acesse o histórico de pesquisas feitas, bem como o resultado dessas pesquisas.

## Tecnologias Utilizadas

### Backend
- **Linguagem de Programação**: Kotlin
- **Framework Web**: Spring Boot
- **Banco de Dados**: HSQLDB para armazenar o histórico de números pesquisados e seus resultados.

### Frontend
- **Linguagem de Programação:**:  JavaScript
- **Framework Frontend**:  React.js
- **Gerenciador de pacotes**:  npm

## Principais Bibliotecas e Ferramentas Utilizadas
### Backend
- **Testes unitários**: Mockito e JUnit

### Frontend
- **Cliente HTTP**:  Axios
- **Estilização**:  CSS configurado manualmente

## Como Executar Localmente

### Requisitos
- Java Development Kit (JDK) 8 ou superior instalado
- Node.js e npm (Node Package Manager)

### Código fonte:
1. Clone o repositório do GitHub: git@github.com:RitaLB/primenum.git
2. Vá até a pasta individual do frontend e do backend e execute separadamente cada um deles


### Executando Backend:
- Vá até o repositório primenum/backend/primenum e execute o seguinnte comando: 
./gradlew bootRun
Assim q o backend for corretamente inicializado, você pode executar o frontend.

### Executando Frontend:
- Vá até o repositório primenum/frontend/primenum e execute o seguinnte comando: 
npm run dev

Para acessar a web aplication, siga o link fornecido pelo terminal
### Referências e fontes principais de consulta utilizadas
1. 
