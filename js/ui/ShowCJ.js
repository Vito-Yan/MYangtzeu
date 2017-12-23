import React from 'react';
import {
    View,
    Navigator,
    TouchableOpacity,
    ToolbarAndroid,
    Text
} from 'react-native';
export default class ShowCJ extends React.Component {
    constructor(props){
        super(props);
        this.state = {};

    }
    //回到第一个页面去
    onJump(){
        const { navigator } = this.props;
        if (navigator) {
            navigator.pop();
        }
    }

    render(){
        return (

            <View >
                <TouchableOpacity onPress = {this.onJump.bind(this)}>
                    <Text> 您的成绩如下（点击返回查询页面） </Text>
                </TouchableOpacity>
            </View>


        );

    }

}