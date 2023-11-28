document.getElementById('cadastroForm').addEventListener('submit', cadastrarJogo);
var result = 0;
function cadastrarJogo(event) {
    event.preventDefault();

    const descricao = document.getElementById('descricao').value;
    const isbn = document.getElementById('isbn').value;

    fetch('http://localhost:8080/Livros', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ descricao, isbn }),
    })
        .then(response => response.json())
        .then(data => {
            alert('Jogo cadastrado com sucesso!');
            document.getElementById('cadastroForm').reset();            
        })
        .catch(error => {
            console.error('Erro ao cadastrar jogo:', error);
        });
}
function pesquisarJogo() {
    const searchId = document.getElementById('searchId').value;

    fetch(`http://localhost:8080/Livros/${searchId}`)
        .then(response => {
            if (response.status === 404) {
                return Promise.reject('Jogo não encontrado');
                result = 0;
            }
            return response.json();
        })
        .then(data => {
            result = 1;
            document.getElementById('descricao').value = `${data.descricao}`;
            document.getElementById('isbn').value = `${data.isbn}`;
        })
        .catch(error => {
            console.error('Erro ao pesquisar jogo:', error);
            const resultadoPesquisa = document.getElementById('resultadoPesquisa');
            resultadoPesquisa.searchId = 'Jogo não encontrado.';
           

        });
}
function atualizarJogo() {
    pesquisarJogo();
    if (result == 1) {
        const descricao = document.getElementById('descricao').value;
        const isbn = document.getElementById('isbn').value;
        const searchId = document.getElementById('searchId').value;

        fetch(`http://localhost:8080/Livros/${searchId}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ descricao, isbn }),
        })
            .then(response => response.json())
            .then(data => {
                alert('Jogo atualizado com sucesso!');
            })
            .catch(error => {
                console.error('Erro ao atualizar jogo:', error);
            });
    } else {
        alert('ID não encontrado na base de dados. Nenhum jogo foi alterado. Favor pesquisar jogo a ser alterado !!!');
    }
}