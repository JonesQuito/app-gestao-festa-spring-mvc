package com.algaworks.festa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.festa.model.Convidado;
import com.algaworks.festa.repository.Convidados;

@Controller
@RequestMapping("/convidados")
public class ConvidadosController {
	
	@Autowired
	private Convidados convidados;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("ListaConvidados");
		mv.addObject("convidados", convidados.findAll());
		mv.addObject(new Convidado());
		return mv;
	}
	
	@PostMapping
	public String salvar(Convidado convidado) {
		this.convidados.save(convidado);
		return "redirect:/convidados";
	}
	
	@PostMapping("/excluir")
	public String excluir(Convidado convidado) {
		this.convidados.delete(convidado);
		return "redirect:/convidados";
	}
	
	@GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
         
		convidados.deleteById(id);
        //service.delete(id);
		System.out.println("Passou no delete" + id);
         
		return "redirect:/convidados";
    }

}
