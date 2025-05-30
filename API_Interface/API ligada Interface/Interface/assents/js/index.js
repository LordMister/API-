
    fetch('http://localhost:8080/api/alunos', {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json'
      },
    })
    .then(response => response.json())
    .then(data => {
      addlinha(data);
    })
    .catch(error => {
      console.log(error);
    });
    
  function addlinha(dadosAPI){
      const tabela = document.getElementById('tabelaCorpo');
      dadosAPI.forEach(element => {   
        const linha = document.createElement('tr');
        linha.innerHTML = `
          <tr>
          <td class="px-4 py-2">${element.id_aluno}</td>
              <td class="px-4 py-2">${element.nome}</td>
              <td class="px-4 py-2">${element.email}</td>
              <td class="px-4 py-2 flex gap-2">
              <button class="bg-green-500 hover:bg-green-600 text-white px-3 py-1 rounded" onclick="editar(this)">Editar</button>
              <button class="bg-red-500 hover:bg-red-600 text-white px-3 py-1 rounded" onclick="remover(this)">Remover</button></td>
          </tr>
        `;
        
        tabela.appendChild(linha);
      });
    }

    function cadastrar(){
      event.preventDefault();
      const nome = document.getElementById('nome').value;
      const email = document.getElementById('email').value;
      if(nome && email){
 
        this.addlinha([{"nome":nome.trim(), "email":email.trim()}]);
        
        //Limpando os campos
        document.getElementById('nome').value = "";
        document.getElementById('email').value = "";

        fetch('http://localhost:8080/api/alunos', { 
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({"nome":nome, "email":email})
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

    function editar(dadosbotao) {
  const linha = dadosbotao.closest('tr');
  const id = linha.querySelector("td").innerText;
  const nomeAtual = linha.children[1].innerText;
  const emailAtual = linha.children[2].innerText;

  Swal.fire({
    title: 'Editar dados',
    html: `
      <input id="editNome" class="swal2-input" placeholder="Nome" value="${nomeAtual}">
      <input id="editEmail" class="swal2-input" placeholder="Email" value="${emailAtual}">
    `,
    confirmButtonText: 'Salvar',
    showCancelButton: true,
    preConfirm: () => {
      const nome = document.getElementById('editNome').value.trim();
      const email = document.getElementById('editEmail').value.trim();

      if (!nome || !email) {
        Swal.showValidationMessage('Preencha todos os campos!');
        return false;
      }

      return { nome, email };
    }
  }).then((result) => {
    if (result.isConfirmed) {

      fetch(`http://localhost:8080/api/alunos/${id}`, {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(result.value)
      })
      .then(() => {
  
        linha.children[1].innerText = result.value.nome;
        linha.children[2].innerText = result.value.email;

        Swal.fire('Atualizado com sucesso!', '', 'success');
      })
      .catch(() => {
        Swal.fire('Erro ao atualizar aluno', '', 'error');
      });
    }
  });
}


    function remover(dadosbotao){
      Swal.fire({
        icon: 'question',
        title: 'Você tem certeza?',
        showCancelButton: true,
        confirmButtonText: 'Sim',
        cancelButtonText: 'Não'
      }).then((result) => {
        if (result.isConfirmed) {
            const linharemover = dadosbotao.closest('tr');
            const id = linharemover.querySelector("td").innerText;

            fetch(`http://localhost:8080/api/alunos/${id}`, {
            method: 'DELETE'
            })
            .then(() => {
              linharemover.remove();
              Swal.fire('Removido com Sucesso!', '', 'success');
            })
            .catch(() => {
              Swal.fire('Erro ao Remover.', '', 'error');
            });

            }
          });
        }
