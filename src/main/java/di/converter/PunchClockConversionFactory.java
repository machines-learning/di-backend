package di.converter;

import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import java.util.HashSet;
import java.util.Set;

public class PunchClockConversionFactory {

    private PunchClockConversionFactory() {

    }

    public static ConversionService conversionService() {
        ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();

        Set<Converter> converters = new HashSet<>();
        converters.add(new RecordConverters.RecordDtoToRecordConverter());
        converters.add(new RecordConverters.RecordToRecordDtoConverter());

        bean.setConverters(converters);
        bean.afterPropertiesSet();
        return bean.getObject();
    }

}
