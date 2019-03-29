package org.jbradfield.gilionaire;

import javax.persistence.Entity;
import java.util.Map;

@Entity
public class Item {
    
    int index;
    String singular;
    int adjective;
    String plural;
    int possessivePronoun;
    int startsWithVowel;
    int VALUE_NOT_USED;
    int pronoun;
    int article;
    String description;
    String name;
    int iconId;
    int itemLevel;
    int rarity;
    int filterGroup;
    int additionalData;
    int itemUICategory;
    int itemSearchCategory;
    int equipSlotCategory;
    int VALUE_NOT_USED_2;
    long stackSize;
    boolean unique;
    boolean untradable;
    boolean indisposable;
    boolean equippable;
    int priceMid;
    int priceLow;
    boolean canBeHq;
    boolean dyeable;
    boolean crestWorthy;
    int itemAction;
    int VALUE_NOT_USED_3;
    int cooldown;
    int repairClassJob;
    int repairItem;
    int glamourItem;
    int salvage;
    boolean collectable;
    int aetherialReduce;
    int equipLevel;
    int VALUE_NOT_USED_4;
    int equipRestriction;
    int classJobCategory;
    int grandCompany;
    int itemSeries;
    int baseParamModifier;
    String modelMail;
    String ModelSub;
    int classJobUse;
    int VALUE_NOT_USED_5;
    int damagePhys;
    int damageMag;
    int delayMs;
    int VALUE_NOT_USED_6;
    int blockRate;
    int block;
    int defensePhys;
    int defenseMag;
    Map<Integer, Integer> baseParams; // 6 KVPs on fields 58-69
    int itemSpecialBonus;
    int itemSpecialBonusParam;
    Map <Integer, Integer> baseParamsSpecial; // 6 KVPs on fields 72-83
    int materializeType;
    int materiaSlotCount;
    boolean advancedMeldingPermitted;
    boolean pvp;
    boolean glamourous;
}
