
function cadastrar(event){
event.preventDefault();
const nome = document.getElementById('idNome').value;
const email = document.getElementById('idEmail').value;
const senha = document.getElementById('idSenha').value;
const cep = document.getElementById('idCep').value;
const endereco = document.getElementById('idEndereco').value;
const numero = document.getElementById('idNumero').value;
const bairro = document.getElementById('idBairro').value; 
const cidade = document.getElementById('idCidade').value; 
const estado = document.getElementById('idEstado').value;

      if(nome && email && senha && cep && endereco && numero && bairro && cidade && estado){
     
document.getElementById('idNome').value = "";
document.getElementById('idEmail').value = "";
document.getElementById('idSenha').value = "";
document.getElementById('idCep').value = "";
document.getElementById('idEndereco').value = "";
document.getElementById('idNumero').value = "";
document.getElementById('idBairro').value = "";
document.getElementById('idCidade').value = "";
document.getElementById('idEstado').value = "";

        fetch('http://localhost:8080/api/funcionario', { 
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({"nome":nome, "email":email, "senha":senha, "cep":cep, "endereco":endereco, "numero":numero, "bairro":bairro, "cidade":cidade, "estado":estado})
        })
        .then(response => response.json())
        .then(data => {
          console.log("Resposta da API:", data);
        })
        .catch(error => {
          console.error("Erro ao enviar dados:", error);
        });
    ''

          Swal.fire({
            icon: 'success',
            title: 'Sucesso!',
            text: 'Cadastro feito com sucesso'
          });
      }else{
        Swal.fire({
          icon: 'error',
          title: 'Erro!',
          text: 'Falta dados para cadastar'
        });
      }
}

document.getElementById("formulario-cadastro").addEventListener("submit", cadastrar);

