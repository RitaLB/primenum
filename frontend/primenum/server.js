import express from 'express';
import { fileURLToPath } from 'url';
import { dirname, join } from 'path';

const app = express();

// Obter o diretório atual do arquivo
const __dirname = dirname(fileURLToPath(import.meta.url));

// Configura o servidor para servir os arquivos estáticos da pasta 'build'
app.use(express.static(join(__dirname, 'build')));

// Define uma rota para servir o arquivo index.html em todas as outras rotas
app.get('*', (req, res) => {
  res.sendFile(join(__dirname, 'build', 'index.html'));
});

// Define a porta em que o servidor irá escutar
const PORT = process.env.PORT || 9090;
app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});
