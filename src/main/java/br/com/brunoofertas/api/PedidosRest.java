package br.com.brunoofertas.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.brunoofertas.model.Pedido;
import br.com.brunoofertas.model.StatusPedido;
import br.com.brunoofertas.repository.PedidoRepository;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosRest {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("aguardando")
	public List<Pedido> getPedidosAguardandoOfertas() {
		Sort sort = Sort.by("id").descending();
		PageRequest paginacao = PageRequest.of(0, 10, sort);
		
		return pedidoRepository.findByStatus(StatusPedido.AGUARDANDO, paginacao);
	}
}
