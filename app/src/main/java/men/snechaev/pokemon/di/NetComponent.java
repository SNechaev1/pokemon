package men.snechaev.pokemon.di;

import dagger.Component;
import men.snechaev.pokemon.network.HttpClient;
import men.snechaev.pokemon.network.WebService;

@NetScope
@Component(modules = {NetModule.class})
public interface NetComponent {

    HttpClient httpClient();
    WebService webService();

}