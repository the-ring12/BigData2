package com.the_ring.storm.add;

import org.apache.log4j.Logger;
import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;
import org.apache.storm.utils.Utils;

import java.util.Map;

public class StormAddTest {



    public static void main(String[] args) {
    }

    class AddSpout extends BaseRichSpout {

        private SpoutOutputCollector spout;
        private int num;

        @Override
        public void open(Map<String, Object> map, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector) {
            spout = spoutOutputCollector;
            num = 1;
        }

        @Override
        public void nextTuple() {
            spout.emit(new Values(num), num);
            num++;
            Utils.sleep(1000);
        }

        @Override
        public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
//            outputFieldsDeclarer.declare("add");
        }
    }

    class AddBolt extends BaseRichBolt {

        OutputCollector bolt;
        int sum;

        @Override
        public void prepare(Map<String, Object> map, TopologyContext topologyContext, OutputCollector outputCollector) {
            bolt = outputCollector;
            sum = 0;
        }

        @Override
        public void execute(Tuple tuple) {
            tuple.getBinaryByField("sum");

        }

        @Override
        public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {

        }
    }
}
