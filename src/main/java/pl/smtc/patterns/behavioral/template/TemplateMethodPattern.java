package pl.smtc.patterns.behavioral.template;

import pl.smtc.menu.ConsoleExample;
import pl.smtc.patterns.behavioral.template.specialization.BluRayReader;
import pl.smtc.patterns.behavioral.template.specialization.CdReader;
import pl.smtc.patterns.behavioral.template.specialization.DvdReader;

public class TemplateMethodPattern implements ConsoleExample {
    @Override
    public void execute() {
        CdReader cd = new CdReader();
        cd.play("Eminem - Kamikaze");
        DvdReader dvd = new DvdReader();
        dvd.play("8. Mile");
        BluRayReader bluRay = new BluRayReader();
        bluRay.play("Avatar");
    }

    @Override
    public String getName() {
        return "Template method pattern";
    }
}
