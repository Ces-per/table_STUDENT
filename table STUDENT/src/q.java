import javax.swing.*;

public class q extends JPanel{


    public q() {
        double skidkasled;
        double vozvratsred;
        double vozvrattek;



        JOptionPane jop = new JOptionPane();

        JFrame frame = new JFrame();
        Object nasvA = JOptionPane.showInputDialog(frame, "Введите название фирмы клиента", "Рассчет скидки v1.0 Вавилон", JOptionPane.PLAIN_MESSAGE);

        String skidA = JOptionPane.showInputDialog("Введите скидку на следующий месяц");
        skidkasled = Double.parseDouble(skidA);

        String vozsA = JOptionPane.showInputDialog("Введите cредний процент возврата");
        vozvratsred = Double.parseDouble(vozsA);

        String voztA = JOptionPane.showInputDialog("Введите процент возврата за текущий месяц");
        vozvrattek = Double.parseDouble(voztA);

        double plusskidka;
        plusskidka = 0;
        if (vozvratsred - vozvrattek < 0)
            jop.showMessageDialog(null,"Извините скидка не предусматривается");

        //Если  скидка на следующий месяц от 19-21%//
        if (19 < skidkasled && skidkasled < 21)
        {
            if(0 <= vozvratsred && vozvratsred <= 2.5) plusskidka = (vozvratsred - vozvrattek) / 1.3;
            if(2.6 <= vozvratsred && vozvratsred <= 8)  plusskidka = (vozvratsred - vozvrattek) / 1.4;
            if(8.1 <= vozvratsred && vozvratsred <= 15) plusskidka = (vozvratsred - vozvrattek) / 3;
            if(15.1 <= vozvratsred && vozvratsred <=300) plusskidka = (vozvratsred - vozvrattek) / 5;
        }

        //Если  скидка на следующий месяц от 21.1-24%//

        else if (21.1 < skidkasled && skidkasled<=24 )
        {if(0 <= vozvratsred && vozvratsred <= 2.5) plusskidka = (vozvratsred - vozvrattek) / 1.2;
            if(2.6 <= vozvratsred && vozvratsred <= 8) plusskidka = (vozvratsred - vozvrattek) / 1.6;
            if(8.1 <= vozvratsred && vozvratsred <= 15) plusskidka = (vozvratsred - vozvrattek) / 4;
            if(15.1 <= vozvratsred && vozvratsred <= 300) plusskidka = (vozvratsred - vozvrattek) / 6;
        }

        //Если  скидка на следующий месяц от 24.1-27%//

        else if (24.1 <= skidkasled && skidkasled <= 27)
        {if (0 <= vozvratsred && vozvratsred <= 2.5) plusskidka = (vozvratsred - vozvrattek) / 1.1;
            if (2.6 <= vozvratsred && vozvratsred <= 8) plusskidka = (vozvratsred - vozvrattek) / 1.8;
            if(8.1 <= vozvratsred && vozvratsred <= 15) plusskidka = (vozvratsred - vozvrattek) / 5;
            if(15.1 <= vozvratsred && vozvratsred <= 300) plusskidka = (vozvratsred - vozvrattek) / 8;
        }

        //Если  скидка на следующий месяц от 27.1-30%//
        else if (27.1 <= skidkasled && skidkasled <= 30)
        {if (0 <= vozvratsred && vozvratsred <= 2.5) plusskidka = (vozvratsred - vozvrattek) / 0.9;
            if (2.6 <= vozvratsred && vozvratsred <= 8) plusskidka = (vozvratsred - vozvrattek) / 2;
            if(8.1 <= vozvratsred && vozvratsred <= 15) plusskidka = (vozvratsred - vozvrattek) / 8;
            if(15.1 <= vozvratsred && vozvratsred <= 300) plusskidka = (vozvratsred - vozvrattek) / 10;
        }

        double oborotsred;
        double oborottek;

        String oborotsA = JOptionPane.showInputDialog("Введите средний оборот денежных средств");
        oborotsred = Double.parseDouble(oborotsA);

        String oborottA = JOptionPane.showInputDialog("Введите текущий оборот денежных средств");
        oborottek = Double.parseDouble(oborottA);

        double finalskidka;
        finalskidka=0;


        if (0 <= oborottek / oborotsred && oborottek / oborotsred <= 1)
            finalskidka = plusskidka * oborottek / oborotsred;

        if (1.1 <= oborottek / oborotsred && oborottek / oborotsred <= 1.2)
            finalskidka = plusskidka * ((oborottek / oborotsred) - 0.1);

        if (1.21 <= oborottek / oborotsred && oborottek / oborotsred <= 1.5)
            finalskidka = plusskidka + ((oborottek / oborotsred) - 0.8);

        if (1.6 <= oborottek / oborotsred && oborottek / oborotsred <= 10)
            finalskidka = plusskidka + ((oborottek / oborotsred) - 1);



        if (finalskidka+skidkasled<=33) {
            jop.showMessageDialog(null,"Исходные данные : \n Название фирмы: "+nasvA+"\n Предварительная скидка на следующий месяц: "+skidkasled+ "\n Средний процент возврата :"+vozvratsred+"\n Процент возврата за текущий месяц: "+vozvrattek+
                    "\n Средний оборот денежных средств: "+oborotsred+"\n Текущий оборот денежных средств:"+oborottek+"\n"+"\n Дополнительная скидка на следующий месяц для фирмы " +
                    nasvA + " составляет  " + finalskidka+ "\n Итоговая скидка составляет "+ (finalskidka+skidkasled));

        }else
        {jop.showMessageDialog(null,"Исходные данные : \n Название фирмы: "+nasvA+"\n Предварительная скидка на следующий месяц: "+skidkasled+ "\n Средний процент возврата :"+vozvratsred+"\n Процент возврата за текущий месяц: "+vozvrattek+
                "\n Средний оборот денежных средств: "+oborotsred+"\n Текущий оборот денежных средств:"+oborottek+"\n"+"Дополнительная скидка на следующий месяц для фирмы " +
                nasvA + " составляет " + finalskidka+ "\n"+"\n"+"\n Извините, но максимально возможная итоговая скидка равна 33%");

        }

    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new q();
            }
        });

    }

}