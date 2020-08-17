package library.converter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CustomConversionServiceImpl extends GenericConversionService implements CustomConversionService {
}
