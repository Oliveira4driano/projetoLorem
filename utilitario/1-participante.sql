use bd_lorem;
-- -----------------------------------------------------
-- Table `participante`.`inserir`
-- -----------------------------------------------------

drop procedure if exists sp_inserirParticipante;
delimiter #
create procedure sp_inserirParticipante( p_parnome varchar(100), p_parfuncao varchar(100))
	begin 
		insert into participante values(parcodigo, p_parnome, p_parfuncao); 
    end #
delimiter ;

call sp_inserirParticipante('participante1', 'desenvolvedor');

select * from participante;

-- -----------------------------------------------------
-- Table `participante`.`listar`
-- -----------------------------------------------------
drop procedure if exists sp_listarParticipante;
delimiter #
create procedure sp_listarParticipante()
	begin
		 -- declare v_mae varchar(2);
         -- set v_mae = (SELECT TIMESTAMPDIFF(YEAR,aludtnascimento,current_date()) from aluno);
		select  parcodigo, parnome, parfuncao 
			from participante
		           
            ;
    end #
delimiter ;
call sp_listarParticipante();


-- -----------------------------------------------------
-- Table `participante`.`Pesquisar`
-- -----------------------------------------------------

drop procedure if exists sp_pesquisarParticipante;

delimiter #
create procedure sp_pesquisarParticipante(p_participante varchar(100))
	begin 
		select  parcodigo,  parnome, parfuncao 
			
			from participante
				
			where parnome like concat('%', p_participante,'%') or parfuncao like concat('%', p_participante,'%'); 
    end #
    
delimiter ;

call sp_pesquisarParticipante('des');


-- -----------------------------------------------------
-- Table `Participante`.`PesquisarAux`
-- -----------------------------------------------------

drop procedure if exists sp_pesquisarParticipanteAux;
delimiter #
create procedure sp_pesquisarParticipanteAux(p_participante varchar(100))
	begin 
		select parcodigo, parnome,parfuncao
			from participante 
			
			where parnome like concat('%', p_participante,'%'); 
    end #
    
delimiter ;
    
call sp_pesquisarParticipanteAux('2'); 

-- -----------------------------------------------------
-- Table `Aluno`.`alterar`
-- -----------------------------------------------------
drop procedure if exists sp_alterarParticipante;

delimiter #
create procedure sp_alterarParticipante(p_parcodigo int, p_parnome varchar(100), p_parfuncao varchar(100) )
	begin
		update participante
        set parnome = p_parnome, parfuncao = p_parfuncao 
			
        where parcodigo = p_parcodigo;
        
	
    end #
delimiter ;

call sp_alterarParticipante(1,'participante1','desenvolvedor');

-- -----------------------------------------------------
-- Table `Participante`.`excluir`
-- -----------------------------------------------------

drop procedure if exists sp_excluirParticipante;
delimiter #
create procedure sp_excluirParticipante(p_parcodigo int)
	begin 
		delete 
			from participante
		
			where parcodigo = p_parcodigo;
    end #

delimiter ;

call sp_excluirParticipante(2);
        

