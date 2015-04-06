package com.huang.j2ee.ch02;

/**
 * Created By User : Morn
 * Created DateTime: 2015/3/9 15:22
 * Descriptions    :
 */
public class BraveKnight implements Knight {
    private Quest quest;

    public BraveKnight(Quest quest) {
        this.quest = quest;
    }

    @Override
    public void embarkOnQuest() {
        quest.embark();
    }
}
