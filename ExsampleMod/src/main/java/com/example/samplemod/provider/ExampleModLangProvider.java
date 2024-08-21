package com.example.samplemod.provider;

import com.example.samplemod.ExampleMOD;
import com.example.samplemod.ExampleModBlocks;
import com.example.samplemod.ExampleModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public abstract class ExampleModLangProvider extends LanguageProvider {
    public ExampleModLangProvider(PackOutput output, String locale) {
        super(output, ExampleMOD.MOD_ID, locale);
    }

    public static class ExampleModLangJP extends ExampleModLangProvider {

        public ExampleModLangJP(PackOutput output) {
            super(output, "ja_jp");
        }

        @Override
        protected void addTranslations() {

            this.add(ExampleModItems.SMALL_TNT.get(), "小型TNT");
            this.add(ExampleModBlocks.LARGE_TNT.get(), "大型TNT");
            this.add(ExampleModBlocks.TRAVIS_SCOTT.get(), "トラビススコット");
        }
    }

    public static class ExampleModLangUS extends ExampleModLangProvider {

        public ExampleModLangUS(PackOutput output) {

            super(output, "en_us");
        }

        @Override
        protected void addTranslations() {

            this.add(ExampleModItems.SMALL_TNT.get(), "Small TNT");
            this.add(ExampleModBlocks.LARGE_TNT.get(), "Large TNT");
            this.add(ExampleModBlocks.TRAVIS_SCOTT.get(), "Travis scott");

        }
    }
}
