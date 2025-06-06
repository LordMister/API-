const urlApi = 'http://localhost:8080/api/imagens';

document.getElementById('formulario').addEventListener('submit', async (e) => {
    e.preventDefault();
    const nome = document.getElementById('nome').value;
    const url = document.getElementById('url').value;

    if (formulario.dataset.editando === "true") {
        const id = formulario.dataset.idEditando;
        await fetch(`${urlApi}/${id}`, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ nome, url })
        });
        formulario.dataset.editando = "false";
        formulario.dataset.idEditando = "";
        document.querySelector('button[type="submit"]').innerText = "Adicionar";
    } else {
        await fetch(urlApi, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ nome, url })
        });
    }

    document.getElementById('formulario').reset();
    carregarImagens();
});

async function carregarImagens() {
    const response = await fetch(urlApi);
    const imagens = await response.json();
    const galeria = document.getElementById('galeria');
    galeria.innerHTML = '';

    imagens.forEach(imagem => {
        const div = document.createElement('div');
        div.innerHTML = `
            <strong>${imagem.nome}</strong><br>
            <img src="${imagem.url}" alt="${imagem.nome}" width="200"><br>
            <button onclick="editarImagem(${imagem.id}, '${imagem.nome}', '${imagem.url}')">Editar</button>
            <button onclick="removerImagem(${imagem.id})">Remover</button>
            <hr>
        `;
        galeria.appendChild(div);
    });
}

async function removerImagem(id) {
    await fetch(`${urlApi}/${id}`, { method: 'DELETE' });
    carregarImagens();
}

function editarImagem(id, nome, url) {
    document.getElementById('nome').value = nome;
    document.getElementById('url').value = url;
    const formulario = document.getElementById('formulario');
    formulario.dataset.editando = "true";
    formulario.dataset.idEditando = id;
    document.querySelector('button[type="submit"]').innerText = "Salvar";
}

carregarImagens();