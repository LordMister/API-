document.addEventListener('DOMContentLoaded', () => {
  fetch('/funcionario')
    .then(res => res.json())
    .then(funcionarios => {
      const select = document.getElementById('funcionarioSelect');
      funcionarios.forEach(f => {
        const opt = document.createElement('option');
        opt.value = f.id;
        opt.textContent = f.nome;
        select.appendChild(opt);
      });
    });

  fetch('/cargos')
    .then(res => res.json())
    .then(cargos => {
      const select = document.getElementById('cargoSelect');
      cargos.forEach(c => {
        const opt = document.createElement('option');
        opt.value = c.id;
        opt.textContent = c.nome;
        select.appendChild(opt);
      });
    });

  document.getElementById('formVinculo').addEventListener('submit', e => {
    e.preventDefault();

    const funcionarioId = document.getElementById('funcionarioSelect').value;
    const cargoId = document.getElementById('cargoSelect').value;
    const dataInicio = document.getElementById('dataInicio').value;
    const dataFim = document.getElementById('dataFim').value;
    const detalhes = document.getElementById('detalhes').value;

    const payload = {
      funcionario_id: funcionarioId,
      cargo_id: cargoId,
      data_inicio: dataInicio,
      data_fim: dataFim || null,
      detalhes: detalhes
    };

    fetch('/alocar', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(payload)
    })
    .then(res => {
      if (res.ok) {
        Swal.fire('Sucesso!', 'Vínculo cadastrado com sucesso!', 'success');
        document.getElementById('formVinculo').reset();
      } else {
        Swal.fire('Erro!', 'Não foi possível salvar o vínculo.', 'error');
      }
    })
    .catch(err => {
      Swal.fire('Erro!', 'Erro de conexão com o servidor.', 'error');
      console.error(err);
    });
  });
});
