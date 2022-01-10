const e = React.createElement;

class ButtonBtn extends React.Component {
    render() {
        return e(
            'button',
            { onClick: () => console.log('click') },
            this.props.label
        );
    }
}

const domContainer = document.querySelector("#btn");
ReactDOM.render(e(ButtonBtn), domContainer);