package com.yu.taskmanager.biz.impl

import com.yu.taskmanager.api.datas.StoryData
import com.yu.taskmanager.biz.dao.StoryDao
import spock.lang.Specification

/**
 * Created by yu on 15-2-15.
 */
class StoryServiceObjectTest extends Specification {

    private StoryServiceObject serviceObjectStub;
    private StoryDao daoMock;


    void init() {
        serviceObjectStub = new StoryServiceObject();
        daoMock = Mock();
        serviceObjectStub.storyDao = daoMock;
    }

    def "FindInitStoryList"() {

    }

    def "FindTodoStoryList"() {
        given:
//        daoMock.findTodoStoryList(_ as Date, _ as Date )>> {
//            StoryData storyData = [];
//            [storyData];
//        }
        when:
        serviceObjectStub = new StoryServiceObject();
//        daoMock = Mock();
//        serviceObjectStub.storyDao = daoMock;
        serviceObjectStub.findTodoStoryList();
        then:
        1 * daoMock.findTodoStoryList(_ as Date, _ as Date )
    }

    def "AdjustImportance"() {

    }

    def "AdjustPriority"() {

    }

    def "AddStory"() {

    }

    def "RemoveStory"() {

    }

    def "DelStory"() {

    }
}
