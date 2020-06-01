package com.Jackson.Binder.Config;

import com.Jackson.Binder.Enum.Raça;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.PackageVersion;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.json.JsonParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.nio.file.Files;

@Configuration
public class Jackson {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper ();
        //PROPRIEDADES NÂO MAPEADAS NÂO QUEBRAM
        objectMapper.configure (DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES , false);
        //FALHA SE ALGUMA PROPRIEDADE ESTIVER VAZIA
        objectMapper.configure (SerializationFeature.FAIL_ON_EMPTY_BEANS,false);
        //SERVE PARA COMPATIBILIDADE DE ARRAYS, QUANDO TEM UM ARRAY COM UM ITEM, CASO NÃO TENHA ESSA CONFIG ELE SE PERDE
        objectMapper.enable (DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        //SERELIZE DATAS
        objectMapper.registerModules (new JavaTimeModule ());
        objectMapper.registerModules (raçaModuleMapper());
        return objectMapper;
    }
    public SimpleModule raçaModuleMapper(){
        SimpleModule dateModule = new SimpleModule ("JSONRaçaModule", PackageVersion.VERSION);
        dateModule.addSerializer (Raça.class, new RaçaCerialize());
        dateModule.addDeserializer (Raça.class,new RaçaDescerialize ());
        return dateModule;
    }
    class RaçaCerialize extends StdSerializer<Raça>{
        private Files json;

        public RaçaCerialize(){
            super(Raça.class);
        }
        @Override
        public void serialize(Raça raça, JsonGenerator json,SerializerProvider provider) throws IOException{
            json.writeString (Raça.getValue ());
        }
    }
    abstract class RaçaDescerialize extends com.Jackson.Binder.Config.RaçaDescerialize {
        public RaçaDescerialize(){
            super(Raça.class);
        }
        @Override
        public Raça deserialize(JsonParser p, DeserializationContext ctxt)throws IOException,JsonProcessingException{
            return Raça.valueOf (p.getClass());
        }
    }
}