package cat.tophat.redpandas.data;

import cat.tophat.redpandas.RedPandas;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class Translations extends LanguageProvider {

    public Translations(DataGenerator gen, String locale) {
        super(gen, RedPandas.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        String locale = this.getName().replace("Languages: ", "");
        switch(locale) {
        case "es_es":
            addTranslation("Panda rojo", "Generar panda rojo");
        	break;
        case "fr_fr":
            addTranslation("Panda rouge", "Oeuf d'apparition de panda rouge");
        	break;
        default:
            break;
        }
    }

    private void addTranslation(String red_panda, String red_panda_spawn_egg) {
        add(RedPandas.RED_PANDA_ENTITY, red_panda);
        add("item.redpandas.red_panda_spawn_egg", red_panda_spawn_egg);
    }
}
