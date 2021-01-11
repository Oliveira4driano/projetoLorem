use bd_lorem;

use bd_lorem;
-- -----------------------------------------------------
-- Table `projeto`.`inserir`
-- -----------------------------------------------------

drop procedure if exists sp_inserirProjeto;
delimiter #
create procedure sp_inserirProjeto( p_pronome varchar(100), p_prodtinicio varchar(10),
									p_prodttermino varchar(10), p_prorisco int, p_provalor double, p_proparticipante varchar(100))
	begin 
		insert into projeto values(procodigo, p_pronome, p_prodtinicio,p_prodttermino, p_prorisco, p_provalor, p_proparticipante); 
    end #
delimiter ;

call sp_inserirProjeto('projeto1','28-10-2020','20-11-2020', 1 ,2.30, 'desenvolvedor');

select * from projeto;

-- -----------------------------------------------------
-- Table `projeto`.`listar`
-- -----------------------------------------------------
drop procedure if exists sp_listarProjeto;
delimiter #
create procedure sp_listarProjeto()
	begin

		select  procodigo, pronome, prodtinicio, prodttermino, prorisco, provalor, proparticipante
			from projeto
		           
            ;
    end #
delimiter ;
call sp_listarProjeto();




-- -----------------------------------------------------
-- Table `projeto`.`PesquisarAux`
-- -----------------------------------------------------

drop procedure if exists sp_pesquisarProjetoAux;
delimiter #
create procedure sp_pesquisarProjetoAux(p_projeto varchar(100))
	begin 
		select procodigo, pronome, prodtinicio, prodttermino, prorisco, provalor, proparticipante
			from projeto 
			
			where pronome like concat('%', p_projeto,'%'); 
    end #
    
delimiter ;
    
call sp_pesquisarProjetoAux('s'); 


-- -----------------------------------------------------
-- Table `Projeto`.`excluir`
-- -----------------------------------------------------

drop procedure if exists sp_excluirProjeto;
delimiter #
create procedure sp_excluirProjeto(p_projeto int)
	begin 
		delete 
			from projeto
		
			where procodigo = p_projeto;
    end #

delimiter ;

call sp_excluirProjeto(2);