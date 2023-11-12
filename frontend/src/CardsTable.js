import { useEffect, useState } from 'react'
import Card from './Card'

const CardsTable = (props) => {
	const [icons, setIcons] = useState(props.icons);

	const [currnetTic, setCurrentTic] = useState([]);

	useEffect(() => {
		if (currnetTic.length === 2) {
			if (currnetTic[0].name === currnetTic[1].name) {
				setIcons(state => {
					const newState = state.map(row => {
						return row.map(card => {
							return currnetTic.some(v => v.id === card.id) ? { ...card, matched: true } : card;
						})
					})
					return newState;
				});
				setCurrentTic([]);
			} else {
				setTimeout(() => setCurrentTic([]), 1000);
			}
		}

	}, [currnetTic]);


	useEffect(() => {
		setIcons(props.icons)
	}, [props.icons]);

	const handleTic = (name, id, matched) => {
		if (matched) return;
		if (currnetTic.some(card => card.id === id)) return;

		if (currnetTic.length <= 2) {
			setCurrentTic(state => {
				return state.length === 0 ? [{ name, id, matched }] : [...state, { name, id, matched }]
			})
		}
		props.handleSetTurns(state => state += 1);
	};

	return (
		icons.map((row) => {
			return row.map(({ icon, id, name, matched }) => {
				const getColor = () => {
					let color = '';
					if (matched) {
						color = 'green';
					}
					return color;
				}

				return <Card
					key={id}
					onClick={handleTic}
					color={getColor()}
					name={name}
					icon={icon}
					id={id}
					matched={matched}
					flipped={currnetTic.some(card => card.id === id) || matched}
				/>
			})
		}
		)
	)
}

export default CardsTable;