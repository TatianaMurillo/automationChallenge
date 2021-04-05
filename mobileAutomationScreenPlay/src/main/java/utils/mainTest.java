package utils;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;

public class mainTest  {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {


         Object[] list= Class.forName("utils.PIE").getEnumConstants();

       double value =  LongitudesConversion.PIE.valueOf("KILOMETERS").value;
       System.out.println(String.format("%.8f", LongitudesConversion.PIE.valueOf("KILOMETERS").value));


        DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        df.setMaximumFractionDigits(340); // 340 = DecimalFormat.DOUBLE_FRACTION_DIGITS

        System.out.println(df.format(LongitudesConversion.PIE.valueOf("KILOMETERS").value)); // Output: 0.00000021

       System.out.println(value);

    }


}
