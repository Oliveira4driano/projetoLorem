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
		select  parnome, parfuncao 
			from participante
		             order by parnome
            ;
    end #
delimiter ;
call sp_listarParticipante();

