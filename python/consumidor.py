import pika
import json

def consumer_callback(ch, method, properties, body): 
    novos_livros = json.loads(body)
    print 'Quantidade de livros', len(novos_livros)
    for livro in novos_livro:
        print 'Nome: ', livro['nome'], 'Editora:', livro[editora]

