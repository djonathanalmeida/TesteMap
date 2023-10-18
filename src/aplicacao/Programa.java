package aplicacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Map<String, Integer> map = new LinkedHashMap<>();

		System.out.println("Informe o caminho do arquivo: ");
		String caminho = sc.next();

		try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {

			String linha = br.readLine();
			while (linha != null) {

				String[] campos = linha.split(",");
				String chave = campos[0];
				Integer valor = Integer.parseInt(campos[1]);

				if (map.containsKey(chave)) {
					int contVotos = map.get(chave);
					map.put(chave, valor + contVotos);
				} else {
					map.put(chave, valor);
				}

				linha = br.readLine();

			}
			for (String chave : map.keySet()) {
				System.out.println(chave + ": " + map.get(chave));
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		sc.close();

	}

}
