package ch.bfh.tom.camp.model;

import org.apache.commons.io.IOUtils;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

@Entity
public class Hero {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    private String name;
    private double atk;
    private double def;
    private double hp;
    private double xp;
    private int level;
    private double price;
    private String imagePath;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAtk() {
        return atk;
    }

    public void setAtk(double atk) {
        this.atk = atk;
    }

    public double getDef() {
        return def;
    }

    public void setDef(double def) {
        this.def = def;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public double getXp() {
        return xp;
    }

    public void setXp(double xp) {
        while (xp >= 100.0) {
            xp -= 100.0;
            this.levelUp();
        }

        this.xp = xp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    private void levelUp() {
        setLevel(getLevel() + 1);

        this.setAtk(Math.min(this.getAtk() * 1.05, 100.0));
        this.setDef(Math.min(this.getDef() * 1.05, 100.0));
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;

    }

    public byte[] getImage() {
        InputStream in = getClass().getResourceAsStream(this.imagePath);
        byte[] media = new byte[0];
        try {
            media = IOUtils.toByteArray(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return media;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return atk == hero.atk &&
                def == hero.def &&
                hp == hero.hp &&
                level == hero.level &&
                xp == hero.xp &&
                id.equals(hero.id) &&
                name.equals(hero.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, atk, def, hp, xp, level);
    }
}
