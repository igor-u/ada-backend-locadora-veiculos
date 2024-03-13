package com.locadora.repository;

import java.util.List;

public interface CrudRepository<T> {
	
	T cadastrar(T t);
	
	List<T> buscarPorParteDoNome(String s);
	
	T renomear(T t, String s);
	
	T alterarIdentificador(T t, String s);
	
	void excluir(T t);

}
